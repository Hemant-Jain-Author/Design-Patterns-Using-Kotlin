class HealthCheckSingleton private constructor() {
    private val servers: MutableList<String> = ArrayList()

    fun addServer() {
        servers.add("Server 1")
        servers.add("Server 2")
    }

    fun changeServer() {
        servers.removeAt(servers.size - 1)
        servers.add("Server 5")
    }

    fun getServers(): List<String> {
        return this.servers
    }

    companion object {
        var instance: HealthCheckSingleton? = null
            get() {
                if (field == null) {
                    field = HealthCheckSingleton()
                }
                return field
            }
            private set

        @JvmStatic
        fun main() {
            val hc1 = instance
            hc1!!.addServer()

            val hc2 = instance
            hc2!!.addServer()

            println(hc1.getServers())
            println(hc2.getServers())
        }
    }
} /*
[Server 1, Server 2, Server 1, Server 2]
[Server 1, Server 2, Server 1, Server 2]
 */

