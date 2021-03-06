/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package training.entity;

import java.io.File;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zr4mbo
 */
@Entity
@Table(name = "QUESTIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questions.findAll", query = "SELECT q FROM Questions q")
    , @NamedQuery(name = "Questions.findByQuestionsId", query = "SELECT q FROM Questions q WHERE q.questionsId = :questionsId")
    , @NamedQuery(name = "Questions.findByQuestiontype", query = "SELECT q FROM Questions q WHERE q.questiontype = :questiontype")
    , @NamedQuery(name = "Questions.findByQuestion", query = "SELECT q FROM Questions q WHERE q.question = :question")})
public class Questions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="questionsseq")
    @SequenceGenerator(name="questionsseq" ,sequenceName="questionsseq", allocationSize=1)
    @Column(name = "QUESTIONS_ID",nullable=false)
    private Integer questionsId;
    @Basic(optional = false)
    @Column(name = "QUESTIONTYPE",nullable=false,length=32)
    private String questiontype;
    @Basic(optional = false)
    @Column(name = "QUESTION",nullable=false,length=255)
    private String question;
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID")
    @ManyToOne(optional = false)
    private Category categoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionsId")
    private Collection<Answer> answerCollection;

    public Questions() {
    }

    public Questions(Integer questionsId) {
        this.questionsId = questionsId;
    }

    public Questions(Integer questionsId, String questiontype, String question) {
        this.questionsId = questionsId;
        this.questiontype = questiontype;
        this.question = question;
    }

    public Integer getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(Integer questionsId) {
        this.questionsId = questionsId;
    }

    public String getQuestiontype() {
        return questiontype;
    }

    public void setQuestiontype(String questiontype) {
        this.questiontype = questiontype;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    @XmlTransient
    public Collection<Answer> getAnswerCollection() {
        return answerCollection;
    }

    public void setAnswerCollection(Collection<Answer> answerCollection) {
        this.answerCollection = answerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionsId != null ? questionsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questions)) {
            return false;
        }
        Questions other = (Questions) object;
        if ((this.questionsId == null && other.questionsId != null) || (this.questionsId != null && !this.questionsId.equals(other.questionsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "training.entity.Questions[ questionsId=" + questionsId + " ]";
    }
    
    
   
}
