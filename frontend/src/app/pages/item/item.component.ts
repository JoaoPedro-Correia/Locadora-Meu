import { Component, OnInit } from '@angular/core';
import { LayoutBaseComponent } from '../../components/layout-base/layout-base.component';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { ConfirmPopupModule } from 'primeng/confirmpopup';
import { SplitButtonModule } from 'primeng/splitbutton';
import { TableModule } from 'primeng/table';
import { ToastModule } from 'primeng/toast';
import { DialogComponent } from '../../components/dialog/dialog.component';
import { ItemService } from '../../services/item.service';
import { ConfirmationService, MessageService } from 'primeng/api';
import { Item } from '../../interfaces/item';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-classe',
  standalone: true,
  imports: [LayoutBaseComponent, TableModule, DialogComponent, ButtonModule, ToastModule, SplitButtonModule, ConfirmPopupModule, FormsModule, DatePipe],
  templateUrl: './item.component.html',
  providers: [MessageService, ConfirmationService, DatePipe],
  styles: ``
})
export class ItemComponent implements OnInit{
  isDialogOpen: boolean = false;
  items!: Item[]
  itemToEdit!: Item | null;
  item: string = '';
  dtAquisicao: string = '';
  tipoItem: string = '';

  constructor(private messageService: MessageService, private itemService: ItemService, private confirmationService: ConfirmationService, private datePipe: DatePipe) {}

  ngOnInit(): void {
    this.listAll()
  }

  toggleDialog(){
    this.item = ''
    this.dtAquisicao = ''
    this.tipoItem = ''
    this.isDialogOpen = !this.isDialogOpen
  }

  listAll(){
    this.itemService.listAll().subscribe({
      next: (res) => {
        this.items = res.dados
      },
      error: () => {
        this.messageService.add({ severity: 'error', summary: 'Erro', detail: 'Erro ao listar classes' });
      }
    })
  }

  handleSave(){
    if(!this.item){
      this.messageService.add({ severity: 'warn', summary: 'Aviso', detail: 'Preencha todos os campos' });
      return
    }

    if(this.itemToEdit){
      this.edit()
    }else{
      this.create()
    }
  }

  handleEdit(id: number){
    this.itemService.listById(id).subscribe({
      next: (res) => {
        this.itemToEdit = res.dados
        this.item = this.itemToEdit.numSerie;
        this.tipoItem = this.itemToEdit.tipoItem;
        this.dtAquisicao = this.datePipe.transform(this.itemToEdit.dtAquisicao, 'yyyy-MM-dd') || ''
        this.isDialogOpen = true
      },
      error: () => {
        this.messageService.add({ severity: 'error', summary: 'Erro', detail: 'Erro ao editar classe' });
      }
    })
  }

  handleDelete(event: Event, id: number){
    this.confirmationService.confirm({
      target: event.target as EventTarget,
      message: 'Realmente deseja excluir este registro?',
      icon: 'pi pi-info-circle',
      acceptButtonStyleClass: 'p-button-danger p-button-sm',
      accept: () => {
        this.delete(id)
      },
    });
  }

  edit(){
    const obj: Item = {
      numSerie: this.item,
      dtAquisicao: this.dtAquisicao,
      tipoItem: this.tipoItem,
      id: this.itemToEdit?.id
    }

    this.itemService.update(obj).subscribe({
      next: () => {
        this.messageService.add({ severity: 'success', summary: 'Sucesso', detail: 'Registro atualizado com sucesso', life: 3000 });
        this.itemToEdit = null
        this.listAll()
        this.toggleDialog()
      },
      error: () => {
        this.messageService.add({ severity: 'error', summary: 'Erro', detail: 'Erro ao atualizar registro' });
      }
    })
  }

  create(){
    const obj: Item = {
      numSerie: this.item,
      dtAquisicao: this.dtAquisicao,
      tipoItem: this.tipoItem,
    }

    this.itemService.create(obj).subscribe({
      next: () => {
        this.messageService.add({ severity: 'success', summary: 'Sucesso', detail: 'Registro inserido com sucesso', life: 3000 });
        this.listAll()
        this.toggleDialog()
      },
      error: () => {
        this.messageService.add({ severity: 'error', summary: 'Erro', detail: 'Erro ao inserir registro' });
      }
    })
  }

  delete(id: number){
    this.itemService.delete(id).subscribe({
      next: () => {
        this.messageService.add({ severity: 'success', summary: 'Sucesso', detail: 'Registro excluído com sucesso', life: 3000 });
        this.listAll()
      },
      error: () => {
        this.messageService.add({ severity: 'error', summary: 'Erro', detail: 'Erro ao excluir registro' });
      }
    })
  }

}
