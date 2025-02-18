package rules

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class MyTestRule(val name: String = "default") : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                println("In @TestRule $name before Test")
                base.evaluate()
                println("In @TestRule $name after Test")
            }

        }
    }
}