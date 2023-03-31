package me.dio.credit.application.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "customer")
data class Customer(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var firtName: String = "",

    @Column(nullable = false)
    var lastName: String = "",

    @Column(nullable = false, unique = true)
    val cpf: String,

    @Column(nullable = false, unique = true)
    var email: String = "",

    @Column(nullable = false)
    var income: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false)
    var passowrd: String = "",

    @Column(nullable = false)
    @Embedded
    var address: Address = Address(),

    @Column(nullable = false)
    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = arrayOf(
            CascadeType.REMOVE,
            CascadeType.PERSIST
        ), mappedBy = "customer"
    )
    var credits: List<Credit> = mutableListOf()
)
