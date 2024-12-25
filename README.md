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
   ![Screenshot_20241225-154732](https://github.com/user-attachments/assets/a3200fac-66fa-4ee2-b3e5-3ab04ceaa5bd)
![Screenshot_20241225-154737](https://github.com/user-attachments/assets/9a38a9e3-bed8-485d-bcb6-e46c85001b62)

3. **Home Screen**
   Displays categories and popular recipes.
    ![Screenshot_20241225-152147](https://github.com/user-attachments/assets/a534d008-76cf-4dfb-8dcf-0cd61d59d5a5)
   
5. **Recipe Details**
   View detailed instructions and ingredients.
![Screenshot_20241225-152200](https://github.com/user-attachments/assets/85ac9045-e4ca-4d94-94bb-a319b25d8d78)

6. ** Search functionality   
    you can find your favorite food
   ![Screenshot_20241225-152156](https://github.com/user-attachments/assets/1e20d772-1b82-4617-ae81-e90b93e88694)

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
