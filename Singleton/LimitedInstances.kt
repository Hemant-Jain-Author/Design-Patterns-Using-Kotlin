class LimitedInstances private constructor() {
    companion object {
        private val instances = mutableListOf<LimitedInstances>()
        private const val limit = 4

        fun createInstance(): LimitedInstances {
            if (instances.size >= limit) {
                throw RuntimeException("Instance Limit reached")
            }

            val instance = LimitedInstances()
            instances.add(instance)
            return instance
        }
    }
}

fun main() {
    LimitedInstances.createInstance()
    LimitedInstances.createInstance()
    LimitedInstances.createInstance()
    LimitedInstances.createInstance()

    try {
        // Attempting to create more instances beyond the limit will throw an exception.
        LimitedInstances.createInstance()
    } catch (e: RuntimeException) {
        println(e.message)
    }
}
