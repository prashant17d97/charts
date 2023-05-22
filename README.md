# Android Bar Chart Project

This project implements an Android application that displays a bar chart using RecyclerView and adapters. It allows users to visualize data in a graphical representation of bars.

<img src="https://github.com/prashant17d97/charts/assets/84988691/6f3db782-763d-404c-9625-e90c21cc302f" alt="App Screenshot" height="720" width="320">

App screenshot

<img src="https://github.com/prashant17d97/charts/assets/84988691/4b434032-be3c-48e5-bdf5-cc27a760fd51" alt="App Screenshot" height="720" width="320">

App screenshot

## Installation

1. Clone the repository to your local machine.
   ```
   git clone https://github.com/prashant17d97/charts.git
   ```

2. Open the project in Android Studio.

3. Build and run the application on an Android device or emulator.

## Usage

Upon launching the application, the main activity (`MainActivity`) will be displayed, showing a bar chart with data.

The bar chart displays values on the y-axis and corresponding labels on the x-axis. The bars represent the values visually, with the height of each bar indicating the magnitude of the value.

The bar chart can be scrolled vertically to view all the bars, and there is also a horizontal bar chart available for a different visualization.

## Implementation Details

The project is built using the following components and concepts:

- `RecyclerView`: Used to display a list of bars in a vertical or horizontal layout.
- `Adapter`: Custom adapters (`BarGraphAdapter` and `BarGraphHorizontalAdapter`) are implemented to bind data to the RecyclerView and create the visual representation of the bars.
- `Data Model`: The `BarModel` class represents the data for each bar, including the bar value and the corresponding label for the x-axis.
- `View Binding`: The `ActivityMainBinding` class is utilized to bind the layout elements in the activity.

## Contributing

Contributions to this project are welcome. Here are the suggested steps to contribute:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make the necessary changes and additions.
4. Test your changes to ensure they work as expected.
5. Submit a pull request detailing your changes.

Please make sure to follow the coding conventions and standards used in the project.

## Acknowledgements

This project makes use of the following libraries:

- Android Jetpack libraries
- RecyclerView

Special thanks to the creators and contributors of these libraries for their valuable work.

## Author

[Prashant Singh](https://github.com/prashant17d97)
