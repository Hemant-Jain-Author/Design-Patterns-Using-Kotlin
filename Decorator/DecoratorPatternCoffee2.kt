interface ICoffee {
    fun getCost(): Int
    fun getIngredients(): String
}

// SimpleCoffee (ConcreteComponent)
class SimpleCoffee : ICoffee {
    override fun getCost(): Int {
        return 10
    }

    override fun getIngredients(): String {
        return "Coffee"
    }
}

open class CoffeeDecorator(protected var component: ICoffee, 
                            protected var decoratorName: String = "",
                            protected var decoratorCost: Int = 0) : ICoffee {

    override fun getCost(): Int {
        return component.getCost() + decoratorCost
    }

    override fun getIngredients(): String {
        return component.getIngredients() + ", $decoratorName"
    }
}

// MilkDecorator (ConcreteDecorator)
class MilkDecorator(component: ICoffee) : CoffeeDecorator(component, "Milk", 4) {
    override fun getCost(): Int {
        return super.getCost()
    }
}

// EspressoDecorator (ConcreteDecorator)
class EspressoDecorator(component: ICoffee) : CoffeeDecorator(component, "Espresso", 5) {
    override fun getCost(): Int {
        return super.getCost()
    }
}

// Client code
fun main() {
    val component: ICoffee = SimpleCoffee()
    val decorator1: ICoffee = MilkDecorator(component)
    val decorator2: ICoffee = EspressoDecorator(decorator1)
    println("Coffee cost is :: ${decorator2.getCost()}")
    println("Coffee ingredients are :: ${decorator2.getIngredients()}")

    val latte: ICoffee = MilkDecorator(MilkDecorator(SimpleCoffee()))
    println("Coffee cost is :: ${latte.getCost()}")
    println("Coffee ingredients are :: ${latte.getIngredients()}")
}

/*
Coffee cost is :: 19
Coffee ingredients are :: Coffee, Milk, Espresso
Coffee cost is :: 18
Coffee ingredients are :: Coffee, Milk, Milk
*/