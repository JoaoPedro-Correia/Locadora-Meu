import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CrudService } from '../classes/CrudService';
import { Titulo } from '../interfaces/titulo';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})

export class TituloService extends CrudService<Titulo>{
  constructor(httpClient: HttpClient) {
    super(httpClient, `${environment.apiUrl}/Titulo`)
  }
}
