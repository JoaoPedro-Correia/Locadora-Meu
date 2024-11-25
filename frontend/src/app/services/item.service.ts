import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CrudService } from '../classes/CrudService';
import { Item } from '../interfaces/item';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})

export class ItemService extends CrudService<Item>{
  constructor(httpClient: HttpClient) {
    super(httpClient, `${environment.apiUrl}/Item`)
  }
}
