
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgChartsModule } from 'ng2-charts';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminAuthComponent } from './admin-auth/admin-auth.component';
import { FormsModule } from '@angular/forms';

import { DeleteCommentComponent } from './delete-comment/delete-comment.component';
import { ChangeThemeComponent } from './change-theme/change-theme.component';

import { ValidateProjectsComponent } from './validate-project/validate-project.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FileUploadModule } from 'ng2-file-upload';


import { NavbarComponent } from './navbar/navbar.component';
import { CompleteNavbarComponent } from './complete-navbar/complete-navbar.component';
import { MainPageComponent } from './main-page/main-page.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { AboutComponent } from './about/about.component';


import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { ContactComponent } from './contact/contact.component';
import { AdminMessagesComponent } from './admin-messages/admin-messages.component';
import { ProjectFormComponent } from './project-form/project-form.component';
import { NavbarCreatComponent } from './navbar-creat/navbar-creat.component';
import { SolutionComponent } from './solution/solution.component';
import { AccueilComponent } from './accueil/accueil.component';
import { ResetpasswordComponent } from './resetpassword/resetpassword.component';
import { SatisticalsComponent } from './satisticals/satisticals.component';
import { DonationFormComponent } from './donation-form/donation-form.component';
import { DonationProjetComponent } from './donation-projet/donation-projet.component';
import { FooterComponent } from './footer/footer.component';
import { FaqComponent } from './faq/faq.component';
import { SettingComponent } from './setting/setting.component';
import { SupportersComponent } from './supporters/supporters.component';
import { StoryComponent } from './story/story.component';

import { ContactpartnerComponent } from './contactpartner/contactpartner.component';
import { SeoComponent } from './seo/seo.component';
import { CoachComponent } from './coach/coach.component';
import { HttpClientModule } from '@angular/common/http';







@NgModule({
  declarations: [
    AppComponent,
    AdminAuthComponent,
  
    DeleteCommentComponent,
    ChangeThemeComponent,
    
    ValidateProjectsComponent,
    
   
    NavbarComponent,
    CompleteNavbarComponent,
    MainPageComponent,
    DashboardComponent,
    ContactUsComponent,
    AboutComponent,
   
  
    
    SigninComponent,
    SignupComponent,
    ContactComponent,
    AdminMessagesComponent,
    ProjectFormComponent,
    NavbarCreatComponent,
    SolutionComponent,
    AccueilComponent,
    ResetpasswordComponent,
    SatisticalsComponent,
    DonationFormComponent,
    DonationProjetComponent,
    FooterComponent,
    FaqComponent,
    SettingComponent,
    SupportersComponent,
    StoryComponent,
   
    ContactpartnerComponent,
    SeoComponent,
    CoachComponent,  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgChartsModule,
    ReactiveFormsModule,
    FileUploadModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
export interface Project {
  id?: number;
  title: string;
  description: string;
  draft: boolean;
  images: string[];
  videos: string[];
}