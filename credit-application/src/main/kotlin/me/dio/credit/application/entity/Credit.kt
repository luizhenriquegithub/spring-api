package me.dio.credit.application.entity

import jakarta.persistence.*
import me.dio.credit.application.enummeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "credit")
data class Credit(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long? = null,

    @Column(nullable = false, unique = true)
    val creditCode: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val creditValue: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false)
    val dayFirstInstallment: LocalDate,

    @Column(nullable = false)
    val numberOfInstallments: Int = 0,

    @Enumerated
    val status: Status = Status.IN_PROGRESS,

    @ManyToOne
    var customer: Customer? = null
)
