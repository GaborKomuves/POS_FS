# POS_FS

## Point of Sale - Full Stack (POS_FS)

### Description
POS_FS is a full-stack Point of Sale (POS) application designed to streamline sales transactions and inventory management. This system allows businesses to efficiently handle product sales, track inventory, and generate reports for better decision-making.

### Features
- User authentication and role-based access control
- Product management (add, edit, delete, and view products)
- Sales transactions processing
- Inventory tracking and stock updates
- Order history and receipt generation
- Dashboard with sales analytics
- **Graphical User Interface (GUI) for ease of use**
  - Main screen with a storefront design
  - Role-based buttons for different users (Customer, Manager, Stock Manager, Clerk)
  - Interactive UI to navigate between different functionalities

### Technologies Used
#### Backend:
- Java (Spring Boot)
- PostgreSQL (Database)
- JPA/Hibernate (ORM)
- RESTful API development

#### Frontend:
- HTML, CSS, JavaScript
- React.js (or specify another framework if used)

#### Deployment & Tools:
- NetBeans IDE
- IntelliJ IDEA / VS Code
- Maven (for dependency management)
- Docker (optional, if used)

### Installation & Setup
#### Prerequisites:
- Java 17+
- PostgreSQL installed and running
- Node.js & npm (for frontend)
- Maven (for backend dependencies)

#### Backend Setup:
```sh
# Clone the repository
git clone https://github.com/GaborKomuves/POS_FS.git
cd POS_FS/backend

# Configure application.properties with your PostgreSQL credentials

# Build and run the backend
mvn clean install
mvn spring-boot:run
```

#### Frontend Setup:
```sh
cd POS_FS/frontend

# Install dependencies
npm install

# Start the frontend
yarn start (or npm start)
```

### Usage
- Navigate to `http://localhost:3000/` (or the configured frontend port) to access the application.
- Log in as an admin/user to manage products and transactions.
- Use the dashboard to view sales data and inventory updates.
- Interact with the GUI for a user-friendly experience.

### Screenshot
Below is a preview of the POS_FS graphical interface:

![image](https://github.com/GaborKomuves/POS_FS/assets/67443270/2f322ec7-736b-49b4-8e46-68f17702e150)

### Contributing
Contributions are welcome! Please fork the repository and create a pull request with detailed changes.

### License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

### Contact
For any questions or issues, please reach out via [GitHub Issues](https://github.com/GaborKomuves/POS_FS/issues).

