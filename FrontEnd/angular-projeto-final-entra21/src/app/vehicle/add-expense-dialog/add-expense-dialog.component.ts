import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, NonNullableFormBuilder } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { VehicleExpenseService } from '../../service/vehicle-expense.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-add-expense-dialog',
  templateUrl: './add-expense-dialog.component.html',
  styleUrls: ['./add-expense-dialog.component.scss']
})
export class AddExpenseDialogComponent implements OnInit {

  form = this.formBuilder.group({
    description: '',
    date: '',
    value: [<number | undefined>(undefined)],
    vehicleId: 0
  })

  constructor(
    public dialogRef: MatDialogRef<AddExpenseDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public vehicleId: number,
    private formBuilder: NonNullableFormBuilder,
    private expenseService: VehicleExpenseService,
    private snackBar: MatSnackBar
  ) {
    this.form.patchValue({
      vehicleId: this.vehicleId
    })
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.parseDate();

    this.expenseService.save(this.form.value).subscribe({
      next: () => this.onSuccess(),
      error: (e) => this.onError()
    })
  }

  parseDate() {
    let day = this.form.value.date!.substring(0, 2);
    let month = this.form.value.date!.substring(2, 4);
    let year = this.form.value.date!.substring(4, 8);
    let dateParsed = year + '-' + month + '-' + day;
    this.form.patchValue({ date: dateParsed })
  }

  private onSuccess() {
    this.snackBar.open('Veículo atualizado com sucesso!', '', { duration: 3000 })
    this.dialogRef.close();
  }

  private onError() {
    this.snackBar.open('Erro ao cadastrar veículo.', '', { duration: 3000 })
  }


}
