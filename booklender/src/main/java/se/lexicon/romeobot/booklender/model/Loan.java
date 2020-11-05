package se.lexicon.romeobot.booklender.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Loan {

    private long loanId;
    private LibraryUser loanTaker;
    private Book book;
    private LocalDate loanDate;
    private boolean terminated;

    public Loan() {
    }

    // needed to add id temporary to run tests
    public Loan(long loanId, LibraryUser loanTaker, Book book, LocalDate loanDate, boolean terminated) {
        this.loanId = loanId;
        this.loanTaker = loanTaker;
        this.book = book;
        this.loanDate = loanDate;
        this.terminated = terminated;
    }

    public long getloanId() {
        return loanId;
    }

    public LibraryUser getLoanTaker() {
        return loanTaker;
    }

    public void setLoanTaker(LibraryUser loanTaker) {
        this.loanTaker = loanTaker;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isOverdue() {
        if(isTerminated()){
            return false;
        } else if(getLoanDate().plusDays(book.getMaxLoanDays()).isBefore(LocalDate.now())) {
            return true;
        } else return false;
    }

    public BigDecimal getFine() {
        BigDecimal fine = new BigDecimal("0");
        if(isOverdue()) {
            fine = BigDecimal.valueOf(Period.between(getLoanDate().plusDays(book.getMaxLoanDays()),
                    (LocalDate.now())).getDays()).multiply(book.getFinePerDay());
        }
        return fine;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

    public boolean extendloan(int days) {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return loanId == loan.loanId &&
                Objects.equals(loanTaker, loan.loanTaker) &&
                Objects.equals(book, loan.book) &&
                Objects.equals(loanDate, loan.loanDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId, loanTaker, book, loanDate);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + loanId +
                ", loanTaker=" + loanTaker +
                ", book=" + book +
                ", loanDate=" + loanDate +
                ", terminated=" + terminated +
                '}';
    }
}
