import { FormBuilder, FormGroup, Validators, FormArray } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-project-form',
  templateUrl: './project-form.component.html',
  styleUrls: ['./project-form.component.css'],
})
export class ProjectFormComponent implements OnInit {
  projectForm: FormGroup;
  categories: any[] = [];

  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.projectForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      story: ['', Validators.required],
      category: ['category1', Validators.required],
      deadline: ['', Validators.required],
      money: ['', Validators.required],
      whatsapp: ['', Validators.required],
      images: this.fb.array(['']),
      videos: this.fb.array(['']),
    });
  }

  ngOnInit(): void {
    this.loadCategories();
  }

  loadCategories(): void {
    this.http.get<any[]>('http://localhost:3001/api/v1/categories').subscribe(
      (data) => {
        this.categories = data;
      },
      (error) => {
        console.error('Error fetching categories', error);
      }
    );
  }

  addPicture(): void {
    const images = this.projectForm.get('images') as FormArray;
    images.push(this.fb.control(''));
  }

  addVideo(): void {
    const videos = this.projectForm.get('videos') as FormArray;
    videos.push(this.fb.control(''));
  }

  saveDraft(): void {
    console.log('Draft Saved', this.projectForm.value);
  }

  onSubmit(): void {
    console.log('Form Submitted', this.projectForm.value);
  }
}
