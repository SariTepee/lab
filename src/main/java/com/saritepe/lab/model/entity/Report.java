package com.saritepe.lab.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(nullable = false, unique = true)
    private String fileNumber;
    private String patientFirstName;
    private String patientLastName;
    @Column(nullable = false, unique = true, length = 11)
    private String patientIdentityNumber;
    private String diagnosisTitle;
    private String diagnosisDetail;

    private String dateOfIssue;

    private String image;

    @ManyToOne
    @JoinColumn(name = "lab_worker_id")
    private LabWorker labWorker;


    public static final class ReportBuilder {
        private Long id;
        private @NotEmpty String fileNumber;
        private String patientFirstName;
        private String patientLastName;
        private String patientIdentityNumber;
        private String diagnosisTitle;
        private String diagnosisDetail;
        private String dateOfIssue;
        private String image;
        private LabWorker labWorker;

        private ReportBuilder() {
        }

        public static ReportBuilder aReportWith() {
            return new ReportBuilder();
        }

        public ReportBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ReportBuilder fileNumber(String fileNumber) {
            this.fileNumber = fileNumber;
            return this;
        }

        public ReportBuilder patientFirstName(String patientFirstName) {
            this.patientFirstName = patientFirstName;
            return this;
        }

        public ReportBuilder patientLastName(String patientLastName) {
            this.patientLastName = patientLastName;
            return this;
        }

        public ReportBuilder patientIdentityNumber(String patientIdentityNumber) {
            this.patientIdentityNumber = patientIdentityNumber;
            return this;
        }

        public ReportBuilder diagnosisTitle(String diagnosisTitle) {
            this.diagnosisTitle = diagnosisTitle;
            return this;
        }

        public ReportBuilder diagnosisDetail(String diagnosisDetail) {
            this.diagnosisDetail = diagnosisDetail;
            return this;
        }

        public ReportBuilder dateOfIssue(String dateOfIssue) {
            this.dateOfIssue = dateOfIssue;
            return this;
        }

        public ReportBuilder image(String image) {
            this.image = image;
            return this;
        }

        public ReportBuilder labWorker(LabWorker labWorker) {
            this.labWorker = labWorker;
            return this;
        }

        public Report build() {
            Report report = new Report();
            report.setId(id);
            report.setFileNumber(fileNumber);
            report.setPatientFirstName(patientFirstName);
            report.setPatientLastName(patientLastName);
            report.setPatientIdentityNumber(patientIdentityNumber);
            report.setDiagnosisTitle(diagnosisTitle);
            report.setDiagnosisDetail(diagnosisDetail);
            report.setDateOfIssue(dateOfIssue);
            report.setImage(image);
            report.setLabWorker(labWorker);
            return report;
        }
    }
}
