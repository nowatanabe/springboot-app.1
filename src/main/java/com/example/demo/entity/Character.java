package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "character_class_id", referencedColumnName = "id")
    private CharacterClass characterClass;

    @Column(nullable = true)
    private Long level;

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public Account getAccount()  { return this.account; };
    public void setAccount(Account account) { this.account = account; }
    public CharacterClass getCharacterClass() { return this.characterClass; }
    public void setCharacterClass(CharacterClass characterClass) { this.characterClass = characterClass; }
    public Long getLevel() { return this.level; }
    public void setLevel(Long level) { this.level = level; }

}
