# StockMaster – Inventory Management System (IMS)

A modular, full-stack Inventory Management System built using **Spring Boot** (Backend API) and **Next.js** (Frontend).  
This system digitizes all stock operations and replaces manual registers, Excel sheets, and scattered tracking methods with a centralized, real-time, user-friendly platforms.

## 🚀 Features

### 1. Authentication
- User Signup / Login  
- OTP-based password reset  
- Redirect to Dashboard after login  

## 📊 Dashboard Overview
The dashboard provides:
- Total Products in Stock  
- Low Stock / Out of Stock  
- Pending Receipts & Deliveries  
- Internal Transfers Scheduled  
- Dynamic Filters for Document Type, Status, Warehouse, and Category  

## 🧭 Navigation Modules
- Dashboard  
- Products  
- Receipts  
- Delivery Orders  
- Inventory Adjustments  
- Move History  
- Settings (Warehouse)  
- Profile  

## 📦 Core Modules

### 1. Product Management
Create & manage products with:
- Name  
- SKU / Code  
- Category  
- Unit of Measure  
- Initial Stock  
- Stock per warehouse/location  

### 2. Receipts (Incoming Goods)
Process:
1. Create receipt  
2. Add supplier & products  
3. Enter received quantity  
4. Validate → Stock increases  

### 3. Delivery Orders (Outgoing Goods)
Process:
1. Pick  
2. Pack  
3. Validate → Stock decreases  

### 4. Internal Transfers
Move stock between:
- Warehouses  
- Racks  
- Locations  
(All logged in Stock Ledger)

### 5. Stock Adjustments
Fix mismatches between recorded & physical stock.

## ✨ Additional Features
- Low stock alerts  
- Multi-warehouse support  
- SKU search  
- Smart filters  

## 🔄 Inventory Flow Example
1. Receive 100 kg Steel → +100  
2. Transfer to production → location updated  
3. Deliver 20 kg → –20  
4. Adjust 3 kg damaged → –3  

## 🛠️ Tech Stack

### Backend (Spring Boot)
- Java 17+  
- Spring Web  
- Spring Data MongoDB  
- Spring Security  
- JWT  
- Lombok  

### Frontend (Next.js)
- Next js

## 📁 Project Structure
```
root/
│── backend/
│── frontend/
└── README.md
```

## 📌 Future Improvements
- Role-based access  
- Reports  
- QR/Barcode scanning  
- Mobile App  

