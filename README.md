# Warehouse Inventory & Point of Sale (POS) System

**Developer:** Rahsya Benova Akbar

A comprehensive Java desktop application designed to streamline retail and warehouse operations. This system integrates a Point of Sale (POS) front-end for processing customer transactions with a robust backend inventory management system, featuring real-time stock tracking, role-based access, and entity management.

---

## Key Features

* **Role-Based Access Control:** Secure login system supporting distinct privileges for `ADMINISTRATOR` (full access) and `CASHIER` (limited to sales operations).
* **Real-Time Inventory Tracking:** Automatically deductions from stock during sales and increments during supplier purchases.
* **Point of Sale (POS):** Efficient checkout interface for processing customer orders and calculating revenue.
* **Entity Management (CRM/Vendor):** Maintain comprehensive directories for Customers, Suppliers, and System Users.
* **Activity Logging:** Automated tracking of system access (`userlogs`) and detailed transaction histories (`salesinfo`, `purchaseinfo`).

---

## System Modules & Pages

The application is modularized into distinct user interface (UI) pages to handle specific business processes cleanly:

### Authentication & Core Dashboards
* **Login Page (`LoginPage`)**: Secure entry point validating credentials against the database.
* **Home Page (`HomePage`)**: Main landing screen post-login.
* **Dashboard (`Dashboard`)**: Analytical view summarizing key business metrics and system navigation.

### Inventory & Transactions
* **Product Page (`ProductPage`)**: Master catalog manager to Add, Update, or Delete product details (Cost, Sell Price, Brand).
* **Current Stock (`CurrentStockPage`)**: Real-time monitoring interface displaying the exact quantity of products currently in the warehouse.
* **Sales Page / POS (`SalesPage`)**: The checkout interface to log purchases, process transactions, and automatically deduct stock.
* **Purchase Page (`PurchasePage`)**: Procurement interface for buying new stock from vendors and incrementing warehouse inventory.

### Directories
* **Customer Page (`CustomerPage`)**: CRM module for client directory maintenance.
* **Supplier Page (`SupplierPage`)**: Vendor management module for tracking supplier details.
* **Users Page (`UsersPage`)**: Administrative panel for employee account management and role assignment.

---

## Database Schema

The backend utilizes an optimized relational database (`inventory`) with the following core tables:
* `users`: System credentials and role assignments.
* `products`: Master item catalog.
* `currentstock`: Real-time quantity tracker linked to product codes.
* `customers` & `suppliers`: External contact directories.
* `purchaseinfo`: Inbound transaction logs.
* `salesinfo`: Outbound transaction logs (Revenue).
* `userlogs`: System audit trail.

---

## Installation & Setup

### 1. Database Configuration
1.  Ensure you have a MySQL server running (default port `3306`).
2.  Import the provided `inventory.sql` file into your database server to create the schema and initial data.
3.  Configure your database credentials (username and password) in the `src/Database/DBCredentials.xml` file.

### 2. Build Instructions
1.  Open the project in your preferred Java IDE (e.g., NetBeans, IntelliJ, Eclipse).
2.  Ensure `mysql-connector-j-9.2.0.jar` and `jcalendar-1.4.jar` are added to your project's build path/libraries.
3.  Build the project. The IDE should automatically compile the classes and copy the required JAR dependencies into the `dist/lib` directory.

### 3. Execution
To run the application via the command line, navigate to the `dist` folder and execute:
