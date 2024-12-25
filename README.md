# Recipe App

Welcome to the **Recipe App**, an Android application that helps food enthusiasts discover and organize their favorite recipes. This app includes features for browsing categories, viewing recipes, and managing user authentication.

---

## Features

- **User Authentication**: Sign up, log in, and reset passwords.
- **Search Recipes**: Search for recipes based on keywords.
- **Recipe Categories**: Browse recipes by categories such as Salad, Dinner, Drinks, Pizza, and Snacks.
- **Popular Recipes**: View trending or popular recipes.
- **MVVM Architecture**: The app is built using the MVVM architectural pattern for better maintainability.
- **API Integration**: Fetch data dynamically using Retrofit.
- **Navigation Drawer**: Includes options for "About Us" and "Privacy Policy."

---

## Project Structure

```
app
├── manifests
│   └── AndroidManifest.xml
├── kotlin+java
    └── com.example.recipes
        ├── Adapter
        │   ├── category_adapter
        │   ├── RecipesAdapter
        │   └── search_item_adapter
        ├── Apis
        │   ├── ApiInterface
        │   └── retrofitobject
        ├── category
        │   └── category_recipe
        ├── drawerActivity
        │   ├── aboutus
        │   └── privacy
        ├── login
        │   ├── forgetpassword
        │   ├── signIn
        │   ├── signUp
        │   └── splash
        ├── model
        │   ├── mydata
        │   ├── Recipe
        │   └── usermodel
        ├── mvvm
        │   ├── recipesRepository
        │   ├── recipesViewmodel
        │   └── recipesViewmodelFactory
        └── showdata
            ├── searchActivity
            ├── show_data
            └── Localhelper.kt
```
---

## Technologies Used

- **Programming Language**: Kotlin + Java
- **Architecture**: MVVM
- **Network**: Retrofit for API calls
- **UI Components**: RecyclerView, Navigation Drawer

---

## Screenshots

1. **Authentication**
Sign up, Sign in, and Forgot Password flows.
   
![Screenshot 2024-12-25 155542](https://github.com/user-attachments/assets/d2115e12-b402-4080-b094-bb71808075aa)
![Screenshot 2024-12-25 155606](https://github.com/user-attachments/assets/c35230e2-33e8-4d71-88ef-82ac3293549c)
![Screenshot 2024-12-25 155554](https://github.com/user-attachments/assets/d635d389-bc38-49da-aeb0-dba38da69122)

3. **Home Screen**
Displays categories and popular recipes.

![Screenshot 2024-12-25 155431](https://github.com/user-attachments/assets/15a5f294-a61c-4677-90f2-bed1c8dc1bfc)
![Screenshot 2024-12-25 155445](https://github.com/user-attachments/assets/c39c732e-910c-4ce6-aa9d-a1503ee70168)

5. **Recipe Details**
View detailed instructions and ingredients.

![Screenshot 2024-12-25 155514](https://github.com/user-attachments/assets/32d86d72-1adc-446f-88e7-ef27688d4dc3)
![Screenshot 2024-12-25 155528](https://github.com/user-attachments/assets/d4e3636a-5a8f-4c02-830b-acf6aeb599c2)

6. ** Search functionality   
you can find your favorite food
   
![Screenshot 2024-12-25 155503](https://github.com/user-attachments/assets/75990a60-4e92-4c24-a6fc-e2130d33b152)

---

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/recipe-app.git
   ```
2. Open the project in Android Studio.
3. Sync Gradle.
4. Run the application on an emulator or a physical device.

---

## Contributions

Contributions are welcome! Feel free to fork the repository and submit a pull request.

---

## Contact

For questions or feedback, please reach out at your-email@example.com.
