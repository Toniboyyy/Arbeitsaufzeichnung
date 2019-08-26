import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, CanActivate, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../service/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {

  constructor(private authService: AuthService,
    private router: Router) {}
  
  canActivate(): boolean {
    if (this.authService.getUserRole() == 'ADMIN') {
      this.router.navigate(['/user']);
      return true;
    } else if(this.authService.getUserRole() == 'USER') {
      this.router.navigate(['/day']);
      return false;
    } else {
      return false;
    }
  }
}
