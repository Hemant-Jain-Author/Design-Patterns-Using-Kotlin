interface Coffee {
    val cost: Int
    val ingredients: String
}

// SimpleCoffee (ConcreteComponent)
class SimpleCoffee : Coffee {
    override val cost: Int = 10
    override val ingredients: String = "Coffee"
}

// CoffeeDecorator (Decorator)
abstract class CoffeeDecorator(protected var component: Coffee) : Coffee {
    abstract override val cost: Int
    abstract override val ingredients: String
}

// MilkDecorator (ConcreteDecorator)
class MilkDecorator(component: Coffee) : CoffeeDecorator(component) {
    override val cost: Int = component.cost + 4
    override val ingredients: String = component.ingredients + ", Milk"
}

// EspressoDecorator (ConcreteDecorator)
class EspressoDecorator(component: Coffee) : CoffeeDecorator(component) {
    override val cost: Int = component.cost + 5
    override val ingredients: String = component.ingredients + ", Espresso"
}

// Client code
fun main() {
    val component: Coffee = SimpleCoffee()
    val decorator1: Coffee = MilkDecorator(component)
    val decorator2: Coffee = EspressoDecorator(decorator1)
    println("Coffee cost is :: " + decorator2.cost)
    println("Coffee ingredients are :: " + decorator2.ingredients)

    val latte: Coffee = MilkDecorator(MilkDecorator(SimpleCoffee()))
    println("Coffee cost is :: " + latte.cost)
    println("Coffee ingredients are :: " + latte.ingredients)
}

/*
Coffee cost is :: 19
Coffee ingredients are :: Coffee, Milk, Espresso
Coffee cost is :: 18
Coffee ingredients are :: Coffee, Milk, Milk
*/

