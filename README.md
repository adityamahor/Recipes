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

1. **Home Screen**
   Displays categories and popular recipes.
2. **Recipe Details**
   View detailed instructions and ingredients.
3. **Authentication**
   Sign up, Sign in, and Forgot Password flows.

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

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.

---

## Contact

For questions or feedback, please reach out at your-email@example.com.
