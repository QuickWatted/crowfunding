import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  firstname: string = '';
  lastname: string = '';
  email: string = '';
  phone: string = '';
  city: string = '';
  state: string = '';
  password: string = '';
  confirmPassword: string = '';
  membershipType: string = '';

  errorMessage: string = '';

  constructor(private router: Router, private http: HttpClient) {}

  signup() {
    // Check if passwords match
    if (this.password !== this.confirmPassword) {
      this.errorMessage = 'Passwords do not match';
      return;
    }

    // Prepare data to send to the backend
    const signupData = {
      firstName: this.firstname,
      lastName: this.lastname,
      email: this.email,
      phoneNumber: this.phone,
      city: this.city,
      state: this.state,
      password: this.password,
      membershipType: this.membershipType
    };

    // Send the data to the backend API
    this.http.post('http://localhost:3001/api/v1/members/register', signupData)
      .subscribe(
        (response: any) => {
          // Registration successful, you may handle the response accordingly
          console.log(response);
          this.router.navigate(['/navbar-creat']); // Redirect to login page after successful signup
        },
        (error: any) => {
          // Registration failed, handle the error
          console.error(error);
          this.errorMessage = 'Registration failed. Please try again.';
        }
      );
  }
}