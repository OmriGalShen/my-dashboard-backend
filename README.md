# My Dashboard 
My Dashboard is a simple dashboard application that shows current
online users.

## What is this?  
This is the backend portion of the project which supplies a simple rest api 

## Tools:
- Sprint Boot (Java)
- Maven
- Postgress Database  

## Live demo url:
https://my-dashboard-backend.herokuapp.com

## REST API:

| Description | Request type  |Request Format | Body Format |Result Format |
| :---:   | :-: | :-: | :-: | :-: |
| get all online users | GET | "/online-clients"  | None |[{username:string, loginTime:Date, lastUpdated:string, ip:string},..]   |

| Description | Request type  |Request Format | Body Format |Result Format |
| :---:   | :-: | :-: | :-: | :-: |
| get client details | GET | "/client-details/{username}"  |None | {username:string, registerTime:Date, loginCount:number}     |

| Description | Request type  |Request Format | Body Format |Result Format |
| :---:   | :-: | :-: | :-: | :-: |
| register a new client | POST  | "/register-client"| {username:string, password:String, email:string, ip:string}|{username:string, registerTime:Date, loginCount:number} |

| Description | Request type  |Request Format | Body Format |Result Format |
| :---:   | :-: | :-: | :-: | :-: |
| login a client | POST  |"/login-client"| {email:string, password:String} |Raise error if login failed  |

| Description | Request type  |Request Format | Body Format |Result Format |
| :---:   | :-: | :-: | :-: | :-: |
| logout a client | POST  |"/logout-client/{username}" | None |void |

| Description | Request type  |Request Format | Body Format |Result Format |
| :---:   | :-: | :-: | :-: | :-: |
| delete a client | DELETE  |"/client/{username}"  | None |void |
