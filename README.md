# mari_sistemasalud

- [ ] **Layout 17(perfil o profile)**
Los cambios realizados para realizar esta pantalla fue que se agregaron colores y se agregaron strings 
siendo los strings: 

```xml
    <string name="mi_perfil">Mi perfil</string>
    <string name="ajustes_estilo_vida">Ajustes de estilo de vida</string>
    <string name="mis_metas">Mis metas</string>
    <string name="aniadir_metas">Añadir</string>
    <string name="cerrar_sesion_profile">Cerrar sesión</string>
    <string name="escribeUnaNota_metas">Escribe una nota</string>
```
Mientras que los colores agregados fueron

```xml
    <color name="text_color_gray">#a9a9c4</color>
    <color name="text_color_title">#8b8bb1</color>
    <color name="profile_background">#8787ae</color>
    <color name="color_btn_profile">#e2e2f1</color>
    <color name="text_profile">#4b4c73</color>
    <color name="notas_text_dark">#5d5e82</color>
    <color name="checkbox_metas">#9595b8</color>
```

mientras que por otro lado también agregué un vector asset de 48x48 de color blanco se agregó este drawable también **rounded_profile_button** y no agregué el nombre adecuado 
a los btn debido a que aún no se conoce, siendo que también se agregó **rounded_log_out_background** este drawable para que se utlizará en btn de cerrar sesión

---
- [ ]  **layout 19 (metas)** En esta pantalla se crea un list view que utilzará el layout **metasView** en el cual de la misma forma que lo anterior se utilizan elementos ya definido
previamente como el caso de **rounded_purple_button**
