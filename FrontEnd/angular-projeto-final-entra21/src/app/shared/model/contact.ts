import { Client } from './client';

export interface Contact {
  id: number,
  contactType: string,
  description: string,
  client: Client
}
