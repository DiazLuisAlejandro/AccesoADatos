import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css',
  
})

export class NavbarComponent {
  auth: any;
  router: any;
  logout() {
  this.auth.logout();
  this.router.navigate(['/login']);
}
}