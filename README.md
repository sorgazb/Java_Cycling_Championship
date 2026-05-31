# Java Cycling Championship

<p align="center">
  <img src="https://github.com/sorgazb/Java_Cycling_Championship/assets/150727714/3fa53493-72aa-4706-b42b-500923e31808" alt="Java Cycling Championship Screenshot" />
</p>

![Java](https://img.shields.io/badge/Java-17-f89820?style=for-the-badge&logo=openjdk)&nbsp;![Eclipse](https://img.shields.io/badge/Eclipse-IDE-2c2255?style=for-the-badge&logo=eclipseide)&nbsp;![Herencia](https://img.shields.io/badge/Herencia-%26_Polimorfismo-007396?style=for-the-badge)&nbsp;![Comparators](https://img.shields.io/badge/Comparators-%26_Enums-e53935?style=for-the-badge)&nbsp;![DP - UEX](https://img.shields.io/badge/DP-UEX_GIIC-1565c0?style=for-the-badge)

> **Java Cycling Championship** es una simulación de un campeonato ciclista desarrollada en Java como proyecto final de la asignatura **Diseño y Programación (DP)** del Grado en Ingeniería Informática y de Computadores (GIIC) en la **Universidad de Extremadura (UEX)**. Implementa herencia, polimorfismo, `Comparators`, `Enums` y lectura de ficheros.

---

## 📋 Descripción

El proyecto modela el comportamiento de un campeonato ciclista por etapas, con equipos, ciclistas de distintas categorías y bicicletas de diferentes tipos. Los conceptos aplicados incluyen:

- **Herencia y polimorfismo**: jerarquía de ciclistas (`Novato`, `Experimentado`, `Estrella`) y bicicletas (`Estándar`, `Rápida`, `Prototipo`).
- **Comparators**: ordenación personalizada de ciclistas y equipos por tiempo, puntos y otros criterios.
- **Enums**: tipos de etapa, categorías de ciclista y tipo de bicicleta.
- **Lectura de ficheros**: carga de datos iniciales de equipos y ciclistas desde ficheros de texto.
- **Organización del campeonato**: gestión de etapas, clasificaciones y resultados.

---

## 🏗️ Estructura del Proyecto

```txt
Java_Cycling_Championship/
├── src/
│   └── demo/
│       ├── Bicicleta.java              # Clase base de bicicleta
│       ├── BicicletaRapida.java         # Hereda de Bicicleta
│       ├── BicicletaPrototipo.java      # Hereda de Bicicleta
│       ├── Ciclista.java               # Clase base de ciclista
│       ├── CiclistaNovato.java          # Hereda de Ciclista
│       ├── CiclistaExperimentado.java   # Hereda de Ciclista
│       ├── CiclistaEstrella.java        # Hereda de Ciclista
│       ├── Equipo.java                 # Gestión de equipos y sus ciclistas
│       ├── Etapa.java                  # Representación de una etapa del campeonato
│       ├── Organizacion.java           # Coordinación general del campeonato
│       ├── comparadores/               # Comparators para ordenación de clasificaciones
│       ├── enums/                      # Enums de tipo de etapa, bicicleta y ciclista
│       └── datosIniciales/             # Clase(s) de carga de datos desde ficheros
├── ficheros/                       # Ficheros .txt con datos de equipos y ciclistas
└── Entrega Final. Proyecto_2022-2023.pdf  # Enunciado oficial del proyecto
```

---

## ⚙️ Compilación y Ejecución

Clona el repositorio:
```txt
git clone https://github.com/sorgazb/Java_Cycling_Championship.git
```

Importa el proyecto en **Eclipse IDE**:
```txt
File > Import > Existing Projects into Workspace
Selecciona la carpeta: Java_Cycling_Championship/Java_Cycling_Championship
```

Ejecuta la clase principal desde Eclipse con `Run > Run As > Java Application`.

---

## 🚴 Jerarquía de Clases

| Clase Base | Subclases | Descripción |
|---|---|---|
| `Ciclista` | `CiclistaNovato`, `CiclistaExperimentado`, `CiclistaEstrella` | Tres perfiles con atributos y comportamientos distintos |
| `Bicicleta` | `BicicletaRapida`, `BicicletaPrototipo` | Tipos de bicicleta con diferentes características |

---

## 🤝 Contribución

Haz fork del repositorio.

Crea una rama de trabajo:

```txt
git checkout -b feature/nueva-funcionalidad
```

Realiza tus cambios y haz commit.

Abre un Pull Request describiendo tus mejoras.

---

<p align="center">Proyecto Final DP &ndash; GIIC &ndash; Universidad de Extremadura &ndash; Sergio Orgaz Bravo</p>
