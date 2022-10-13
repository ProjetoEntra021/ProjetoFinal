import { Client } from './client';

export interface Contact {
  id: number,
  contactType: number,
  description: string,
  client: Client
}
