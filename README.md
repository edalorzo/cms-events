### Create Customer Command 

```bash
curl -i -X POST -H "Content-Type:application/json" -H "Accept:application/json" -d '{"email":"edwin@dalorzo.com", "firstName": "Edwin", "lastName": "Dalorzo"}' http://localhost:8080/customer/create-customer
```

### Change Password Command

```bash
curl -i -X POST -d '{"email":"edwin@dalorzo.com", "password":"mazinger"}' -H "Accept:application/json" -H "Content-Type:application/json" http://localhost:8080/customer/change-password
```

### Activate Customer

```bash
 curl -i -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d '{"email":"edwin@dalorzo.com"}' http://localhost:8080/customer/activate
 ```
 
 
 ### Deactivate Customer
 
 ```bash
  curl -i -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d '{"email":"edwin@dalorzo.com"}' http://localhost:8080/customer/deactivate
  ```
  
### TODOs

* ~Implement remote command listener~
* ~Deal with idempotency~
* ~Improve exception throwing~
* Improve exception handling
* Deal with validation.
* Implement Query side using controller.
* Implement Query side using amqp. 