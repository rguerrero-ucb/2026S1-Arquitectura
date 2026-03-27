package main

import "fmt"

type Person struct {
	Name string
	age  int
}

func (p Person) Greet() string {
	return "Hello, my name is " + p.Name
}

func (p *Person) GetAge() int {
	return p.age
}

func duplicar(a int) int {
	return a * 2
}

func separar(a, b int) (int, int) {
	return a / 2, b / 2
}

func dividir(a, b int) (int, error) {
	if b == 0 {
		return 0, fmt.Errorf("cannot divide by zero")
	}
	return a / b, nil
}

func main() {
	var a int = 10
	a = 20

	b := "Hello, Go!"

	println(a)
	println(b)

	if a > 5 {
		println("a is greater than 5")
	} else {
		println("a is not greater than 5")
	}

	for i := 0; i < 5; i++ {
		println("Iteration:", i)
	}

	person := Person{
		Name: "Alice",
		age:  30,
	}

	println(person.Name, person.GetAge())

	result, err := dividir(10, 0)
	if err != nil {
		fmt.Println("Error:", err)
	} else {
		fmt.Println("Result:", result)
	}
}
