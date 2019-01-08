import { Moment } from 'moment';

export interface IUserInfo {
  id?: number;
  phone?: string;
  classLevel?: string;
  school?: string;
  location?: string;
  gender?: string;
  dateofbirth?: Moment;
  device?: string;
  deviceToken?: string;
  userinforlsLogin?: string;
  userinforlsId?: number;
}

export const defaultValue: Readonly<IUserInfo> = {};
