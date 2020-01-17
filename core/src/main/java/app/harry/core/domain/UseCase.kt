package app.harry.core.domain

abstract class UseCase<I, O> {

    abstract fun execute(input: I): O

}