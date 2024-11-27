import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ResponseModelArray, ResponseModelObject } from '../interfaces/responseModel';

export class CrudService<T extends {id?: number}> {
  constructor(private httpClient: HttpClient, private url: string) {}

  listAll(): Observable<T[]> {
    return this.httpClient.get<T[]>(`${this.url}/findAll`);
  }

  listById(id: number): Observable<T> {
    return this.httpClient.get<T>(`${this.url}/findById/${id}`);
  }

  create(obj: T): Observable<T> {
    return this.httpClient.post<T>(`${this.url}/save`, obj);
  }

  update(obj: T): Observable<T> {
    return this.httpClient.put<T>(`${this.url}/update/${obj.id}`, obj);
  }

  delete(id: number): Observable<String> {
    return this.httpClient.delete(`${this.url}/deleteById/${id}`, {responseType:'text'});
  }
}
