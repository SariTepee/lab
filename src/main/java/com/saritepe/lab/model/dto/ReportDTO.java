package com.saritepe.lab.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

@Data
public class ReportDTO {
    private Long id;
    @NotEmpty(message = "Report file number cannot be empty.")
    private String fileNumber;
    @NotEmpty(message = "Patient first name cannot be empty.")
    private String patientFirstName;
    @NotEmpty(message = "Patient last name cannot be empty.")
    private String patientLastName;
    @NotEmpty(message = "Patient identity number cannot be empty.")
    @Length(min = 11, max = 11, message = "Patient identity number length must be 11 characters.")
    private String patientIdentityNumber;
    private String diagnosisTitle;
    private String diagnosisDetail;
    private String dateOfIssue;
    private String image;

    private ReportLabWorkerDTO labWorker;

    @Transient
    public  String getReportImagePath() {
        if (image == null || id == null) return null;
        return "/report-images/" + id + "/" + image;
    }


    public static final class ReportDTOBuilder {
        private Long id;
        private String fileNumber;
        private String patientFirstName;
        private String patientLastName;
        private String patientIdentityNumber;
        private String diagnosisTitle;
        private String diagnosisDetail;
        private String dateOfIssue;
        private String image;
        private ReportLabWorkerDTO labWorker;

        private ReportDTOBuilder() {
        }

        public static ReportDTOBuilder aReportDTOWith() {
            return new ReportDTOBuilder();
        }

        public ReportDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ReportDTOBuilder fileNumber(String fileNumber) {
            this.fileNumber = fileNumber;
            return this;
        }

        public ReportDTOBuilder patientFirstName(String patientFirstName) {
            this.patientFirstName = patientFirstName;
            return this;
        }

        public ReportDTOBuilder patientLastName(String patientLastName) {
            this.patientLastName = patientLastName;
            return this;
        }

        public ReportDTOBuilder patientIdentityNumber(String patientIdentityNumber) {
            this.patientIdentityNumber = patientIdentityNumber;
            return this;
        }

        public ReportDTOBuilder diagnosisTitle(String diagnosisTitle) {
            this.diagnosisTitle = diagnosisTitle;
            return this;
        }

        public ReportDTOBuilder diagnosisDetail(String diagnosisDetail) {
            this.diagnosisDetail = diagnosisDetail;
            return this;
        }

        public ReportDTOBuilder dateOfIssue(String dateOfIssue) {
            this.dateOfIssue = dateOfIssue;
            return this;
        }

        public ReportDTOBuilder image(String image) {
            this.image = image;
            return this;
        }

        public ReportDTOBuilder labWorker(ReportLabWorkerDTO labWorker) {
            this.labWorker = labWorker;
            return this;
        }

        public ReportDTO build() {
            ReportDTO reportDTO = new ReportDTO();
            reportDTO.setId(id);
            reportDTO.setFileNumber(fileNumber);
            reportDTO.setPatientFirstName(patientFirstName);
            reportDTO.setPatientLastName(patientLastName);
            reportDTO.setPatientIdentityNumber(patientIdentityNumber);
            reportDTO.setDiagnosisTitle(diagnosisTitle);
            reportDTO.setDiagnosisDetail(diagnosisDetail);
            reportDTO.setDateOfIssue(dateOfIssue);
            reportDTO.setImage(image);
            reportDTO.setLabWorker(labWorker);
            return reportDTO;
        }
    }
}
