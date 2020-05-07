import { Pipe, PipeTransform } from '@angular/core';
import { DatePipe } from '@angular/common';
import {DateFormat} from 'src/app/models/DateFormat';
 

@Pipe({
  name: 'dateTimeFormat'
})
export class TimestampPipe extends DatePipe implements PipeTransform {
  transform(value: any, args?: any): any {
    return super.transform(value, DateFormat.DATE_TIME_FMT);
  }

}