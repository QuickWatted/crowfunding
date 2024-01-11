import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-resetpassword',
  templateUrl: './resetpassword.component.html',
  styleUrls: ['./resetpassword.component.css']
})
export class ResetpasswordComponent implements OnInit {
  emailReset: string = '';
  newPassword: string = '';
  token: string = '';
  validationError: string = ''; // To store validation error message
  step: number = 1;

  constructor(private activatedRoute: ActivatedRoute, private router: Router, private http: HttpClient) {}

  ngOnInit() {
    // Extract reset token from the URL
    this.activatedRoute.queryParams.subscribe(params => {
      // Uncomment the following line if you still need to extract the reset token
      // this.token = params['token'];
    });
  }

  continue() {
    const request = {
      email: this.emailReset,
    };

    this.http.post('http://localhost:3001/api/v1/members/forgot-password', request, { responseType: 'text' }).subscribe(
      response => {
        console.log(response);
        // Handle success, e.g., show a message to the user
        this.step = 2; // Move to the next step after sending the email
      },
      error => {
        console.error(error);
        // Handle error, e.g., show an error message to the user
      }
    );
  }

  resetPassword() {
    const resetRequest = {
      token: this.token,
      newPassword: this.newPassword
    };

    this.http.post('http://localhost:3001/api/v1/members/reset-password', resetRequest, { responseType: 'text' }).subscribe(
      response => {
        console.log(response);
        this.step = 4;
      },
      error => {
        console.error(error);
        // Handle error, e.g., show an error message to the user
      }
    );
  }

  goToLogin() {
    this.router.navigate(['/signin']);
  }
}
