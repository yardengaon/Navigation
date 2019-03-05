# PacmanNavigation

## Descreption

The project represents a game called Pacman Navigation, the game is performed on img of Google Earth. The course of the game: Choose a map location for Pacmans and fruits, then the goal of the Pacmans to eat the fruits in the shortest time (in terms of distance), the end of the game:
Will be displayed on the map any track that Packman has made
There is an example below the map.

### Gui 
Gui package has the:
- Map: singeltone object, represent the map that we want .
- MainWindow : showing all packmans and fruits path .
### Geom 
Geom package has the:
- ShortestPathAlgo: calculate the shrtest Route to evry packman 
- Point3D: represent a single point3D in the game 
- fruit: represent a single fruit in the game 
- packman: represent a single packman in the game 
- fruits: represent all the fruits in the game 
- packmans: represent all the packmans in the game 
  ..
### Coords 
The Coords package has the:
 #### mycoords class
  Represents a Class that allows us to perform calculations between GPS points such as:
  - Move a point with a vector
  - Calculates a vector between two points
  - Azimuth calculation, Elevation
  - Distance between two points
  ..
 
### File format 
The File format package has:
#### CsvToGame class
The class create a game from csv file
#### GameToKML class
Running on Google Earth simulates a game like in gui in Java
### ExampleAfterRun (the Picture is from GoogleEarth) : 
![screenshot 50](https://user-images.githubusercontent.com/45077625/53831341-46aa1100-3f8d-11e9-9856-a149133a2386.png)
 #### ClassDiagram
![screenshot 48](https://user-images.githubusercontent.com/45077625/53831401-70633800-3f8d-11e9-869d-74c6c6cbdfca.png)
### ExampleGameMap
![screenshot 51](https://user-images.githubusercontent.com/45077625/53831552-c041ff00-3f8d-11e9-992f-aa2f9eb4c1b1.png)
### ExampleBeforeRun
![screenshot 43](https://user-images.githubusercontent.com/45077625/53831571-ce901b00-3f8d-11e9-93bc-0a0b3b2c2f4d.png)
### ExampleMiddelRun
![screenshot 44](https://user-images.githubusercontent.com/45077625/53831690-1151f300-3f8e-11e9-9940-7b6be5acad09.png)
### ExampleAfterRun
![screenshot 47](https://user-images.githubusercontent.com/45077625/53831725-23cc2c80-3f8e-11e9-8c35-21b631e80694.png)
### ExampleKmlRun
![screenshot 50](https://user-images.githubusercontent.com/45077625/53831747-30e91b80-3f8e-11e9-86c1-7e677b19c91f.png)

### Sorces

 - converting coordinates : https://stackoverflow.com/questions/1185408/converting-from-longitude-latitude-to-cartesian-coordinates  

- calculating 3D vector : https://stackoverflow.com/questions/41912407/calculate-a-vector-in-meter-from-two-gps-coordinates 

 - calculating distance : http://www.vias.org/comp_geometry/math_coord_convert_3d.htm

- how to convert csv to kml(from the resource) : http://convertcsv.com/csv-to-kml.htm 

- the idea of Azimuth : https://en.wikipedia.org/wiki/Azimuth
