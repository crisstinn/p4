# p4
API REST de animales - Práctica 4 PAT
    
@PostMapping("/api/animales") //hago un endpoint que sea para crear animales nuevos segun las peticiones y que emplee las clases y funciones definidas en el model
    public Animal crear_animal(@RequestBody Animal nuevo_animal) //para que con el json que me den en la peticion se me cree un objeto animal
    {
        animales.put(nuevo_animal.getNombre(), nuevo_animal); //tengo que meter en el diccionario tanto el nombre del animal como el animal en si animal que estan creando
        return nuevo_animal;
    }

@GetMapping("/api/animales") //pretendo que me muestre todos los animales con sus caracteristicas ya que en la peticion no me estan especificando uno en concreto
    public ArrayList<Animal> listar_todo()
    {
        ArrayList<Animal> listado=new ArrayList<>(animales.values());
        return listado;
    }

@GetMapping("/api/animales/list_nom") //pretendo que me muestre todos los NOMBRES de los animales ya que en la peticion no me estan especificando uno en concreto
    public ArrayList<String> listar_nombres()
    {
        ArrayList<String> list_nom=new ArrayList<>();
        for(Animal ani :animales.values()) //para el animal "ani" dentro de los valores de los animales
        {
            list_nom.add(ani.getNombre()); //cojo su nombre con el metodo que tengo en el model
        }
        //podria haber hecho que me devolviera solo las claves porque coinciden con el nombre--> return(animales.keySet());
        return list_nom;
    }

@GetMapping("/api/contadores/{nombre}") //que solo me muestre todo lo que define a un animal en concreto porque en la peticion me habran especificado que animal ver
    public Animal mostrar_uno(@PathVariable String nombre) //es PathVariable porque el {nombre} que espera recibir va cambiando segun la peticion que haga el usuario
    {
        return animales.get(nombre.toLowerCase()); //que me devuelva toda la info del animal concreto que me estan pidiendo en la peticion
    }

@PutMapping("/api/animales/{nombre}/ecosistema/{ecosistema}") //para actualizar el ecosistema a partir del nombre que el usuario ponga a actualizar
    public Animal actualizar(@PathVariable String nombre, @PathVariable String ecosistema)
    {
        Animal animalActual = animales.get(nombre.toLowerCase());
        if (animalActual == null)
        {
            return null; // para que no de errores si no encuentra el animal que se pretende actualizar
        }
        String foto=animalActual.getImagen();
        Animal animalActualizado = new Animal(nombre, ecosistema, foto);
        animales.put(nombre, animalActualizado);
        return animalActualizado;
    }

@DeleteMapping("/api/animales/{nombre}")
    public Map<String,Animal> eliminar(@PathVariable String nombre)
    {
        animales.remove(nombre.toLowerCase()); //quiero que me devuelva el diccionario por eso elimino el animal usando su clave
        return animales;
    }

