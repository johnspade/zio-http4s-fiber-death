import zio.*
import cats.syntax.all.*
import org.http4s.dsl.Http4sDsl
import org.http4s.ember.server.EmberServerBuilder
import zio.interop.catz.*
import zio.interop.catz.implicits.*
import com.comcast.ip4s.*
import org.http4s.HttpRoutes

object Main extends ZIOAppDefault :
  private val dsl = Http4sDsl[Task]
  import dsl.*

  private val service = HttpRoutes.of[Task] {
    case _ => Ok[String](throw new RuntimeException("oops"))
  }

  private val server = EmberServerBuilder.default[Task]
    .withPort(port"8080")
    .withHost(host"localhost")
    .withHttpApp(service.orNotFound)
    .build
    .toScopedZIO

  override def run = server <* ZIO.never
