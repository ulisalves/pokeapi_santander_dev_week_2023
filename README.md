# Santander Dev Week 2023

Java Restful API criada para o Santander Dev Week 2023

##Diagrama de Classes

```mermaid
classDiagram
  class Pokemon {
    -name: String
    -img: Img
    -power: Powers[]
  }

  class Img {
    -description: String
    -icon: String
  }

  class Powers {
    -description: String
  }

  Pokemon "1" *-- "1" Img
  Pokemon "1" *-- "N" Powers
```

