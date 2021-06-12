package pl.lech.notebook.model;


import javax.persistence.*;

@Entity
@Table(name = "notebook")
public class Notebook {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private java.sql.Timestamp date;
  private String author;
  private String title;
  private String notice;
  private java.sql.Timestamp updDate;

  public Notebook() {
  }

  public Notebook(String author, String title, String notice) {
    this.author = author;
    this.title = title;
    this.notice = notice;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public java.sql.Timestamp getDate() {
    return date;
  }

  public void setDate(java.sql.Timestamp date) {
    this.date = date;
  }


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getNotice() {
    return notice;
  }

  public void setNotice(String notice) {
    this.notice = notice;
  }


  public java.sql.Timestamp getUpdDate() {
    return updDate;
  }

  public void setUpdDate(java.sql.Timestamp updDate) {
    this.updDate = updDate;
  }

  @Override
  public String toString() {
    return "Notebook{" +
            "id=" + id +
            ", date=" + date +
            ", author='" + author + '\'' +
            ", title='" + title + '\'' +
            ", notice='" + notice + '\'' +
            ", updDate=" + updDate +
            '}';
  }
}

