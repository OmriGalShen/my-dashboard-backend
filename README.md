# My Dashboard 
My Dashboard is a simple dashboard application that shows current
online users.

## What is this?  
This is the backend portion of the project which supplies a simple rest api  
[Frontend repository](https://github.com/OmriGalShen/my-dashboard-frontend)

## Tools:
- Sprint Boot (Java)
- Maven
- Postgress Database  

## Live demo:
[Backend live demo](https://my-dashboard-backend.herokuapp.com)  
[Frontend live demo](https://my-dashboard-frontend.netlify.app/)  

## REST API:

| Description | Request type  |Request Format | Body Format |Result Format |
| :----------:  | :----------:  | :----------:  | :----------:  |:----------:  |
| get all online users | GET | "/online-clients"  | None |[{username:string, loginTime:Date, lastUpdated:string, ip:string},..]   |
| get client details | GET | "/client-details/{username}"  |None | {username:string, registerTime:Date, loginCount:number}     |
| register a new client | POST  | "/register-client"| {username:string, password:String, email:string}|{username:string, registerTime:Date, loginCount:number} |
| login a client | POST  |"/login-client"| {email:string, password:String} |{email:string,username:string,password:string}  |
| logout a client | POST  |"/logout-client/{username}" | None |void |
| delete a client | DELETE  |"/client/{username}"  | None |void |
