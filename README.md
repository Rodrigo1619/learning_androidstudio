# moviles
-Jetpack Navigation

añadir la biblioteca (buscar en el navegador ¨bibliotecas jetpack¨)
primer link, luego buscar ¨activity¨ y dar click. Copiar activity_version y pegar en:

build gradle(project) -> arriba de la llave de plugings colocar

ext{
//aqui pegar la variable activity_version

ejemplo:
activity_version = "1.4.0"

}

luego ir al build gradle(module) y dentro de "dependencies" pegar:

implementation "androidx.activity:activity-ktx:$activity_version"

luego en la pagina del navegador, donde salen las librerias, regresar y buscar "fragments" y agregar:

build gradle(project) -> dentro de ext colocar fragment_version

por ejemplo: fragment_version = "1.4.1"

luego ir al build gradle(module) y dentro de "dependencies" pegar:

implementation "androidx.fragment:fragment-ktx:$fragment_version"

luego en el mismo "dependencies" en la misma lista de cosas, colocar de ultimo el

 debugImplementation "androidx.fragment:fragment-testing:$fragment_version"
 
 en la misma pagina de navegador, retroceder y buscar DataBinding y en el mismo build gradle(module):
 
 buscar el apartado android{
 
 } buscar el defaultConfig y abajo de el pegar:
 
 buildFeatures {
        dataBinding true
    }

 en la misma pagina de navegador, retroceder y buscar navigation y en build gradle(project):
 
 en ext pegar: nav_version = "2.4.1"
 
 en build gradle(module):
 
 en dependencies pegar:
 //kotlin
 implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
  implementation "androidx.navigation:navigation-ui-ktx:$nav_version"
  
  y luego de ultimo se pondra:
  
  // Testing Navigation
  androidTestImplementation "androidx.navigation:navigation-testing:$nav_version"
  
  luego se mueve a build gradle(project) y abajo de ext agregar 
  
 buildscript {
 
    repositories {
    
        google()
        
    }
    
    dependencies {
        
        classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
        
    }
    
}

luego colocar ext{} dentro de buildscript arriba de repositories
  
  pasarse a build gradle(module), buscar plugins y pegar dentro:
  
id 'androidx.navigation.safeargs.kotlin'

luego de todo esto, presiona sync now (barra azul de arriba)
