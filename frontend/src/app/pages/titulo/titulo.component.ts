import { Component, OnInit } from '@angular/core';
import { LayoutBaseComponent } from '../../components/layout-base/layout-base.component';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { ConfirmPopupModule } from 'primeng/confirmpopup';
import { SplitButtonModule } from 'primeng/splitbutton';
import { TableModule } from 'primeng/table';
import { ToastModule } from 'primeng/toast';
import { DialogComponent } from '../../components/dialog/dialog.component';
import { TituloService } from '../../services/titulo.service';
import { ConfirmationService, MessageService } from 'primeng/api';
import { Titulo } from '../../interfaces/titulo';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-classe',
  standalone: true,
  imports: [LayoutBaseComponent, TableModule, DialogComponent, ButtonModule, ToastModule, SplitButtonModule, ConfirmPopupModule, FormsModule, DatePipe],
  templateUrl: './titulo.component.html',
  providers: [MessageService, ConfirmationService, DatePipe],
  styles: ``
})
export class TituloComponent implements OnInit{
  isDialogOpen: boolean = false;
  items!: Titulo[]
  itemToEdit!: Titulo | null;
  titulo: string = '';
  ano: string = '';
  sinopse: string = '';
  categoria: string = '';

  constructor(private messageService: MessageService, private tituloService: TituloService, private confirmationService: ConfirmationService, private datePipe: DatePipe) {}

  ngOnInit(): void {
    this.listAll()
  }

  toggleDialog(){
    this.titulo = ''
    this.ano = '';
    this.sinopse = ''
    this.categoria = ''
    this.isDialogOpen = !this.isDialogOpen
  }

  listAll(){
    this.tituloService.listAll().subscribe({
      next: (res) => {
        console.log(res)
        this.items = res
      },
      error: () => {
        this.messageService.add({ severity: 'error', summary: 'Erro', detail: 'Erro ao listar classes' });
      }
    })
  }

  handleSave(){
    if(!this.titulo){
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
    this.tituloService.listById(id).subscribe({
      next: (res) => {
        this.itemToEdit = res;
        this.titulo = this.itemToEdit.nome;
        this.sinopse = this.itemToEdit.sinopse;
        this.categoria = this.itemToEdit.categoria;
        this.ano = this.datePipe.transform(this.itemToEdit.ano, 'yyyy') || ''
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
    const obj: Titulo = {
      nome: this.titulo,
      sinopse: this.sinopse,
      categoria: this.categoria,
      ano: this.ano,
      id: this.itemToEdit?.id
    }

    this.tituloService.update(obj).subscribe({
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
    const obj: Titulo = {
      nome: this.titulo,
      sinopse: this.sinopse,
      categoria: this.categoria,
      ano: this.ano,
    }

    this.tituloService.create(obj).subscribe({
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
    this.tituloService.delete(id).subscribe({
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
