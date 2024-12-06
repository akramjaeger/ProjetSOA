import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private baseUrl = 'http://localhost:8081'; 

  constructor(private http: HttpClient) {}

 
  getUsers(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/users`);
  }

  getUserById(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/users/${id}`);
  }

  addUser(user: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/users`, user);
  }

  updateUser(id: number, user: any): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/users/${id}`, user);
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/users/${id}`);
  }


  getAuthors(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/authors`);
  }

  getAuthorById(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/authors/${id}`);
  }

  addAuthor(author: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/authors`, author);
  }

  updateAuthor(id: number, author: any): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/authors/${id}`, author);
  }

  deleteAuthor(id: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/authors/${id}`);
  }


  getBooks(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/books`);
  }

  getBookById(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/books/${id}`);
  }

  addBook(book: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/books`, book);
  }

  updateBook(id: number, book: any): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/books/${id}`, book);
  }

  deleteBook(id: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/books/${id}`);
  }

  // Borrowing-related methods
  getBorrowings(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/borrowings`);
  }

  getBorrowingById(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/borrowings/${id}`);
  }

  addBorrowing(borrowing: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/borrowings`, borrowing);
  }

  updateBorrowing(id: number, borrowing: any): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/borrowings/${id}`, borrowing);
  }

  deleteBorrowing(id: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/borrowings/${id}`);
  }
}
