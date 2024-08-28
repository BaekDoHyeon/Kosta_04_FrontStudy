package test3;

import java.util.List;

abstract class Animal {
	public void eat() { System.out.println("Animal eating...."); }
}

class Dog extends Animal {
	//eat() {}
	void bark() { System.out.println("Dog Bark..."); }
}

class Cat extends Animal {
	// eat() {}
	void meow() { System.out.println("Cat Meow..."); }
}

public class GenericWildCardTest4 {

	public static void main(String[] args) {
		List<Animal> animals = List.of(new Dog(), new Cat(), new Dog());
		List<Dog> dogs = List.of(new Dog(), new Dog());
		
		takeAnimals(animals);
		takeAnimals(dogs);
	}
	
	//wild card 적용하는 기능 정의 
	
	//public static void takeAnimals(List<Animal> animals) { -> takeAnimals(dogs); 이 부분에서 에러난다. 다형성이 적용되지 않는다..
	//	for(Animal a : animals) a.eat();
	//}
	
	public static void takeAnimals(List<? extends Animal> animals) {
		for(Animal a : animals) a.eat();
	}
	
}
















