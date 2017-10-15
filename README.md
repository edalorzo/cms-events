### Create Customer Command 

```bash
curl -X POST -H "Content-Type:application/json" -H "Accept:application/json" -d '{"email":"edwin@dalorzo.com", "firstName": "Edwin", "lastName": "Dalorzo"}' http://localhost:8080/customer/create-customer
```

### Change Password Command

```bash
curl -i -X POST -d '{"email":"edwin@dalorzo.com", "password":"mazinger"}' -H "Accept:application/json" -H "Content-Type:application/json" http://localhost:8080/customer/change-password
```

