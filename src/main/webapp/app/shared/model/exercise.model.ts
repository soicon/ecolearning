import { Moment } from 'moment';

export interface IExercise {
  id?: number;
  fileName?: string;
  imageUrl?: string;
  createdTime?: Moment;
  exerciseType?: string;
  exerciseuserLogin?: string;
  exerciseuserId?: number;
}

export const defaultValue: Readonly<IExercise> = {};
