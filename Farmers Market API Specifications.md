Farmers Market API
Introduction
This API allows users to manage vendors in a farmers market. It provides functionalities to create, retrieve, update, and delete vendor information.

Base URL
http://localhost:8080/api

Endpoints
1. Create a New Vendor
HTTP Method: POST
Endpoint: /vendor
Description: Allows users to create a new vendor with details like name, description, address, phone number, and email.
Request Headers:
Content-Type: application/json
Request Body:
{
  "name": "Vendor Name",
  "description": "Vendor Description",
  "address": "Vendor Address",
  "phoneNumber": "Vendor Phone Number",
  "email": "vendor@example.com"
}
Responses:
201 Created:
{
  "id": 1,
  "name": "Vendor Name",
  "description": "Vendor Description",
  "address": "Vendor Address",
  "phoneNumber": "Vendor Phone Number",
  "email": "vendor@example.com"
}
400 Bad Request: Invalid input
2. View All Vendors
HTTP Method: GET
Endpoint: /vendor
Description: View the list of all vendors.
Request Headers:
Accept: application/json
Responses:
200 OK:
[
  {
    "id": 1,
    "name": "Vendor Name",
    "description": "Vendor Description",
    "address": "Vendor Address",
    "phoneNumber": "Vendor Phone Number",
    "email": "vendor@example.com"
  },
  {
    "id": 2,
    "name": "Another Vendor",
    "description": "Another Description",
    "address": "Another Address",
    "phoneNumber": "Another Phone Number",
    "email": "another@example.com"
  }
]
204 No Content: No vendors found
3. Retrieve a Single Vendor
HTTP Method: GET
Endpoint: /vendor/{id}
Description: Retrieve details of a single vendor by its ID.
Request Headers:
Accept: application/json
Path Parameters:
id (integer): ID of the vendor
Responses:
200 OK:
{
  "id": 1,
  "name": "Vendor Name",
  "description": "Vendor Description",
  "address": "Vendor Address",
  "phoneNumber": "Vendor Phone Number",
  "email": "vendor@example.com"
}
404 Not Found: Vendor not found
4. Update Vendor Details
HTTP Method: PUT
Endpoint: /vendor/{id}
Description: Update the details of an existing vendor.
Request Headers:
Content-Type: application/json
Path Parameters:
id (integer): ID of the vendor
Request Body:
{
  "name": "Updated Vendor Name",
  "description": "Updated Description",
  "address": "Updated Address",
  "phoneNumber": "Updated Phone Number",
  "email": "updated@example.com"
}
Responses:
200 OK:
{
  "id": 1,
  "name": "Updated Vendor Name",
  "description": "Updated Description",
  "address": "Updated Address",
  "phoneNumber": "Updated Phone Number",
  "email": "updated@example.com"
}
400 Bad Request: Invalid input
404 Not Found: Vendor not found
5. Delete a Vendor
HTTP Method: DELETE
Endpoint: /vendor/{id}
Description: Delete a vendor by its ID.
Request Headers:
Accept: application/json
Path Parameters:
id (integer): ID of the vendor
Responses:
204 No Content: Successfully deleted
404 Not Found: Vendor not found
