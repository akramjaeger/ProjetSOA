import { Routes } from '@angular/router';
import { BooksComponent } from './page/books/books.component';
import { BorrowersComponent } from './page/borrowers/borrowers.component';
import { HomeComponent } from './page/home/home.component';

export const routes: Routes = [

  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'books',
    component: BooksComponent,
  },
  {
    path: 'borrowers',
    component: BorrowersComponent,
  },
];
