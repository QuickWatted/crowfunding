import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent {
    email: string = "";
    password: string = "";
    remember: boolean = false;

    constructor(private router: Router , private http: HttpClient) {}
  
    login() {
      console.log(this.email);
      console.log(this.password);
  
      const bodyData = {
        email: this.email,
        password: this.password,
      };
  
      this.http.post("http://localhost:3001/api/v1/members/login", bodyData).subscribe((resultData: any) => {
        console.log(resultData);
  
        if (resultData.error) {
          alert("Login failed: " + resultData.error);
        } else {
          alert("Login Success");
          this.router.navigate(['/complete-navbar']); // Redirect to the home page
        }
      });
    }

  forgotPassword() {
    console.log('Forgot Password function called');
  }

  private saveUserCredentials() {
    
    console.log('User credentials saved for 30 days');
  }
}